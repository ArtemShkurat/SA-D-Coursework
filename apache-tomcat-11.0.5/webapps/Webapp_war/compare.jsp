<%@ page import="java.util.*" %>
<%@ page import="com.example.webapp.model.Database" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Stock Chart Comparison</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
        <style>
            body { font-family: Arial, sans-serif; text-align: center; padding: 40px; }
            canvas { margin: 20px auto; display: block; width: 1200px !important; height: 600px !important; }
            .controls { margin-top: 20px; }
            select, button { margin: 5px; }
        </style>
    </head>
    <body>
        <%
            String symbol1 = (String) request.getAttribute("symbol1");
            String symbol2 = (String) request.getAttribute("symbol2");

            Map<String, Database> stockData1 = (Map<String, Database>) request.getAttribute("stockData1");
            Map<String, Database> stockData2 = (Map<String, Database>) request.getAttribute("stockData2");

            List<String> allDates = new ArrayList<>(stockData1.keySet());
            Collections.sort(allDates);
        %>

        <h1>Stock Chart: <%= symbol1 %> vs <%= symbol2 %></h1>

        <div class="controls">
            <label for="dayRange">Show last:</label>
            <select id="dayRange" onchange="updateChart()">
                <option value="10">10 days</option>
                <option value="30" selected>30 days</option>
                <option value="60">60 days</option>
                <option value="90">90 days</option>
                <option value="all">All</option>
            </select>
        </div>

        <canvas id="stockChart"></canvas>

        <div class="controls">
            <label for="downloadFormat">Choose format:</label>
            <select id="downloadFormat">
                <option value="png">PNG (Image)</option>
                <option value="pdf">PDF (Document)</option>
            </select>
            <button onclick="handleDownload()">Download</button>
        </div>

        <script>
            const allLabels = [<% for (String date : allDates) { %>"<%= date %>",<% } %>];
            const allCompany1 = [<% for (String date : allDates) { Database d = stockData1.get(date); %><%= d.getClose() %>,<% } %>];
            const allCompany2 = [<% for (String date : allDates) { Database d = stockData2.get(date); %><%= d.getClose() %>,<% } %>];

            const ctx = document.getElementById("stockChart").getContext("2d");
            let chart;

            function createChart(labels, data1, data2) {
                if (chart) chart.destroy();
                chart = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: labels,
                        datasets: [
                            {
                                label: '<%= symbol1 %>',
                                data: data1,
                                borderColor: 'blue',
                                fill: false
                            },
                            {
                                label: '<%= symbol2 %>',
                                data: data2,
                                borderColor: 'red',
                                fill: false
                            }
                        ]
                    }
                });
            }

            function updateChart() {
                const range = document.getElementById("dayRange").value;
                let count = allLabels.length;

                if (range !== "all") {
                    const days = parseInt(range);
                    if (days < count) count = days;
                }

                const labels = allLabels.slice(-count);
                const data1 = allCompany1.slice(-count);
                const data2 = allCompany2.slice(-count);

                createChart(labels, data1, data2);
            }

            updateChart(); // initialize

            async function handleDownload() {
                const format = document.getElementById("downloadFormat").value;
                const canvas = document.getElementById("stockChart");

                if (format === "pdf") {
                    const { jsPDF } = window.jspdf;
                    const pdf = new jsPDF();
                    const imageData = canvas.toDataURL("image/png");
                    pdf.addImage(imageData, "PNG", 10, 10, 180, 100);
                    pdf.save("chart.pdf");
                } else {
                    const image = canvas.toDataURL("image/png");
                    const link = document.createElement("a");
                    link.href = image;
                    link.download = `chart.${format}`;
                    link.click();
                }
            }
        </script>
    </body>
</html>