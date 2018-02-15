<%-- 
    Document   : newjsp
    Created on : Jan 3, 2018, 8:26:12 AM
    Author     : mmh
--%>

<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chart Tools</title>

    </head>

    <body>
        <%
            int saving = 0;
            int diposits = 0;
            int certificate = 0;
            int invesment = 0;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/nbsERP_Dankotuwa", "root", "123");
                CallableStatement rs1 = con.prepareCall("{call `aaaaa`}");
                ResultSet rs = rs1.executeQuery();
                while (rs.next()) {
                    saving = rs.getInt(1);
                    diposits = rs.getInt(2);
                    certificate = rs.getInt(3);
                    invesment = rs.getInt(4);
                }
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        %>
        <link href="css/splash_page.css" rel="stylesheet" type="text/css"/>
        <link href="css/buttons.css" rel="stylesheet" type="text/css"/>
        <link href="css/ui+en,controls+en.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/cahrtApi.js" type="text/javascript"></script>
        <script src="js/cahrt.js" type="text/javascript"></script>
        <div id="hp-banner-right">
            <div style="text-align:center; font-family: Arial, sans-serif;" id="chart_title"><b>Line Chart</b> </div>
            <div id="chart_div" style="margin-top:20px; width:100%; height:200px"><div style="position: relative;"><div style="position: relative; width: 1348px; height: 200px;" dir="ltr"><div style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%;" aria-label="A chart."><svg width="1348" height="200" style="overflow: hidden;" aria-label="A chart."><defs id="defs"><clipPath id="_ABSTRACT_RENDERER_ID_9"><rect x="50" y="5" width="1298" height="170"></rect></clipPath></defs><rect x="0" y="0" width="1348" height="200" stroke="none" stroke-width="0" fill="#ffffff"></rect><g><rect x="50" y="5" width="1298" height="170" stroke="none" stroke-width="0" fill-opacity="0" fill="#ffffff"></rect><g clip-path="url(https://google-developers.appspot.com/chart/index-charts#_ABSTRACT_RENDERER_ID_9)"><g><rect x="50" y="174" width="1298" height="1" stroke="none" stroke-width="0" fill="#cccccc"></rect><rect x="50" y="132" width="1298" height="1" stroke="none" stroke-width="0" fill="#cccccc"></rect><rect x="50" y="90" width="1298" height="1" stroke="none" stroke-width="0" fill="#cccccc"></rect><rect x="50" y="47" width="1298" height="1" stroke="none" stroke-width="0" fill="#cccccc"></rect><rect x="50" y="5" width="1298" height="1" stroke="none" stroke-width="0" fill="#cccccc"></rect></g><g><rect x="50" y="174" width="1298" height="1" stroke="none" stroke-width="0" fill="#333333"></rect></g><g><path d="M212.625,33.66666666666666L536.875,9.724999999999994L861.125,81.55L1185.375,29.441666666666663" stroke="#3366cc" stroke-width="4" fill-opacity="1" fill="none"></path><path d="M212.625,118.16666666666666L536.875,109.71666666666667L861.125,16.76666666666665L1185.375,98.45" stroke="#dc3912" stroke-width="4" fill-opacity="1" fill="none"></path></g></g><g></g><g><g><text text-anchor="middle" x="212.625" y="192.75" font-family="Arial" font-size="15" stroke="none" stroke-width="0" fill="#222222">2004</text></g><g><text text-anchor="middle" x="536.875" y="192.75" font-family="Arial" font-size="15" stroke="none" stroke-width="0" fill="#222222">2009</text></g><g><text text-anchor="middle" x="861.125" y="192.75" font-family="Arial" font-size="15" stroke="none" stroke-width="0" fill="#222222">2010</text></g><g><text text-anchor="middle" x="1185.375" y="192.75" font-family="Arial" font-size="15" stroke="none" stroke-width="0" fill="#222222">2011</text></g><g><text text-anchor="end" x="43" y="179.75" font-family="Arial" font-size="15" stroke="none" stroke-width="0" fill="#444444">0</text></g><g><text text-anchor="end" x="43" y="137.5" font-family="Arial" font-size="15" stroke="none" stroke-width="0" fill="#444444">300</text></g><g><text text-anchor="end" x="43" y="95.25" font-family="Arial" font-size="15" stroke="none" stroke-width="0" fill="#444444">600</text></g><g><text text-anchor="end" x="43" y="53" font-family="Arial" font-size="15" stroke="none" stroke-width="0" fill="#444444">900</text></g><g><text text-anchor="end" x="43" y="10.75" font-family="Arial" font-size="15" stroke="none" stroke-width="0" fill="#444444">1,200</text></g></g></g><g></g></svg><div aria-label="A tabular representation of the data in the chart." style="position: absolute; left: -10000px; top: auto; width: 1px; height: 1px; overflow: hidden;"><table><thead><tr><th>Year</th><th>Sales</th><th>Expenses</th></tr></thead><tbody><tr><td>2004</td><td>1,000</td><td>400</td></tr><tr><td>2009</td><td>1,170</td><td>460</td></tr><tr><td>2010</td><td>660</td><td>1,120</td></tr><tr><td>2011</td><td>1,030</td><td>540</td></tr></tbody></table></div></div></div><div style="display: none; position: absolute; top: 210px; left: 1358px; white-space: nowrap; font-family: Arial; font-size: 15px;" aria-hidden="true">...</div><div></div></div></div>
        </div>
        <div style="clear:left; margin-bottom:40px"></div>
        <div style="text-align:center;">
            <ul class="banner-thumbs">
                <li><img id="chart_pie" src="images/chart/chart_pie.png" alt="pie"></li>
                <li><img id="chart_line" src="images/chart/chart_line_sel.png" alt="line"></li>
                <li><img id="chart_column" src="images/chart/chart_column.png" alt="column"></li>
                <li><img id="chart_area" src="images/chart/chart_area.png" alt="area"></li>
                <li><img id="chart_tree" src="images/chart/chart_tree.png" alt="tree"></li>
                <li><img id="chart_dashboard" src="images/chart/chart_dashboard.png" alt="dashboard"></li>
            </ul>
        </div>
        <script src="js/cahrtLoader.js" type="text/javascript"></script>
        <script type="text/javascript">
            var selected_chart;
            var data;
            var timer;

            // chart thumbs click:
            $(".banner-thumbs img").click(function ()
            {
                stopTimer();
                selectChart($(this).attr("alt"));
            });

            // stop auto play on chart rollover
            $("#chart_div").hover(stopTimer)
                    .mouseleave(startTimer);

            $(window).resize(drawChart);

            // load chart libraries
            //google.load("visualization", "1", {packages:["corechart"]});
            //google.load("visualization", "1", {packages:["treemap"]});
            google.setOnLoadCallback(initCharts);

            function initCharts()
            {
                selectChart("pie");
                startTimer();
            }

            function selectChart(type)
            {
                selected_chart = type;

                // deselect all thumbs
                $(".banner-thumbs img").each(function () {
                    $(this).attr("src",
                            "images/chart/chart_" + $(this).attr("alt") + ".png")
                });

                // select current thumb
                $("#chart_" + selected_chart).attr("src",
                        "images/chart/chart_" + selected_chart + "_sel.png");

                updateChartTitle();
                drawChart();
            }

            function updateChartTitle()
            {
                var title;

                switch (selected_chart) {
                    case "pie":
                        title = "Pie Chart";
                        break;

                    case "line":
                        title = "Line Chart";
                        break;

                    case "column":
                        title = "Column Chart";
                        break;

                    case "area":
                        title = "Area Chart";
                        break;

                    case "tree":
                        title = "Tree Map";
                        break;

                    case "dashboard":
                        title = "Controls and Dashboards";
                        break;
                }
                $("#chart_title").html("<b>" + title + "</b> ");
            }

            function startTimer() {
                timer = setInterval(next, 5000);
            }

            function stopTimer() {
                clearInterval(timer);
            }

            function next() {
                var type = $("#chart_" + selected_chart).parent().next().children()[0].alt;
                if (type == undefined) {
                    type = $(".banner-thumbs img")[0].alt;
                }
                selectChart(type);
            }

            function drawChart()
            {
                switch (selected_chart)
                {
                    case "pie":
                        data = new google.visualization.DataTable();
                        data.addColumn('string', 'Catogory');
                        data.addColumn('number', 'Count');
                        data.addRows([['Saving', <%=saving%>], ['Fixed Diposits', <%=diposits%>], ['Certificate Saving', <%=certificate%>], ['Invesment Saving', <%=invesment%>]]);
                        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
                        chart.draw(data, {
                            width: '100%',
                            height: 200,
                            title: '',
                            backgroundColor: '#ffffff', chartArea: {left: '10%', top: '6%', width: '100%', height: '88%'}});
                        break;

                    case "area":
                        data = new google.visualization.DataTable();
                        data.addColumn('string', 'Year');
                        data.addColumn('number', 'Sales');
                        data.addColumn('number', 'Expenses');
                        data.addRows([
                            ['2004', 1000, 400],
                            ['2005', 1170, 460],
                            ['2006', 660, 1120],
                            ['2007', 1030, 540]
                        ]);

                        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));

                        chart.draw(data, {
                            width: '100%',
                            height: 200,
                            title: '',
                            backgroundColor: '#ffffff',
                            legend: "none",
                            chartArea: {
                                left: 50,
                                top: 5,
                                width: "100%",
                                height: "85%"
                            },
                            hAxis: {
                                title: 'Year',
                                titleTextStyle: {
                                    color: '#FF0000'
                                }
                            },
                            lineWidth: 4,
                            axisTitlesPosition: "none"
                        });
                        break;

                    case "line":
                        data = new google.visualization.DataTable();
                        data.addColumn('string', 'Year');
                        data.addColumn('number', 'Sales');
                        data.addColumn('number', 'Expenses');
                        data.addRows([
                            ['2004', 1000, 400],
                            ['2009', 1170, 460],
                            ['2010', 660, 1120],
                            ['2011', 1030, 540]
                        ]);

                        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

                        chart.draw(data, {
                            width: '100%',
                            height: 200,
                            title: '',
                            backgroundColor: '#ffffff',
                            legend: "none",
                            chartArea: {
                                left: 50,
                                top: 5,
                                width: "100%",
                                height: "85%"
                            },
                            hAxis: {
                                title: 'Year',
                                titleTextStyle: {
                                    color: 'red'
                                }
                            },
                            lineWidth: 4,
                            axisTitlesPosition: "none"
                        });
                        break;

                    case "column":
                        data = new google.visualization.DataTable();
                        data.addColumn('string', 'Year');
                        data.addColumn('number', 'Sales');
                        data.addColumn('number', 'Expenses');
                        data.addRows([
                            ['2004', 1000, 400],
                            ['2009', 1170, 460],
                            ['2010', 660, 1200],
                            ['2011', 1030, 540]
                        ]);

                        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));

                        chart.draw(data, {
                            width: '100%',
                            height: 200,
                            title: '',
                            backgroundColor: '#ffffff',
                            legend: "none",
                            chartArea: {
                                left: 50,
                                top: 5,
                                width: "100%",
                                height: "85%"
                            },
                            hAxis: {
                                title: 'Year',
                                titleTextStyle: {
                                    color: 'red'
                                }
                            },
                            axisTitlesPosition: "none"
                        });
                        break;

                    case "tree":
                        var tree_data = new google.visualization.DataTable();
                        tree_data.addColumn('string', 'Region');
                        tree_data.addColumn('string', 'Parent');
                        tree_data.addColumn('number', 'Market trade volume (size)');
                        tree_data.addColumn('number', 'Market increase/decrease (color)');
                        tree_data.addRows([
                            ["Global", null, 0, 0],
                            ["America", "Global", 0, 0],
                            ["Europe", "Global", 0, 0],
                            ["Asia", "Global", 0, 0],
                            ["Australia", "Global", 0, 0],
                            ["Africa", "Global", 0, 0],
                            ["Brazil", "America", 11, 70],
                            ["USA", "America", 52, 80],
                            ["France", "Europe", 42, 40],
                            ["Germany", "Europe", 31, 30],
                            ["UK", "Europe", 21, 20],
                            ["China", "Asia", 36, -10],
                            ["Japan", "Asia", 20, -20],
                            ["Mongolia", "Asia", 1, -15],
                            ["Israel", "Asia", 12, -24],
                            ["Iran", "Asia", 18, -13],
                            ["Pakistan", "Asia", 11, -25],
                            ["Egypt", "Africa", 21, -90],
                            ["S. Africa", "Africa", 30, -80]
                        ]);

                        $("#chart_div").empty();
                        var chart = new google.visualization.TreeMap(document.getElementById('chart_div'));
                        chart.draw(tree_data, {headerHeight: 15, maxPostDepth: 0});
                        break;

                    case "dashboard":
                        $("#chart_div").empty();
                        $("#chart_div").html('<div id="scatterchart_div"></div>' +
                                '<div id="filter_div"></div>');

                        var dashboard = new google.visualization.Dashboard(
                                document.getElementById('chart_div'));

                        var rangeSlider = new google.visualization.ControlWrapper({
                            'controlType': 'NumberRangeFilter',
                            'containerId': 'filter_div',
                            'options': {
                                'filterColumnLabel': 'Range',
                                'ui.labelStacking': 'vertical',
                                'ui.showRangeValues': false
                            }
                        });

                        data = new google.visualization.DataTable();
                        data.addColumn('number', 'Range');
                        data.addColumn('number', 'B');
                        data.addColumn('number', 'C');
                        data.addColumn('number', 'D');
                        data.addColumn('number', 'E');

                        for (var i = 10; i < 50; i++)
                        {
                            var m = 13;
                            var x = i;
                            var y1 = Math.cos(i / m) * 10 + 10;
                            var y2 = Math.cos(i / m + Math.PI) * 10 + 10;
                            var y3 = Math.sin(i / m) * 10 + 10;
                            var y4 = Math.sin(i / m + Math.PI) * 10 + 10;

                            data.addRow([x, y1, y2, y3, y4]);
                        }

                        var options = {
                            width: '100%',
                            height: 170,
                            title: '',
                            legend: "none",
                            lineWidth: 1,
                            chartArea: {left: 30, top: 5, width: "100%", height: "85%"},
                            hAxis: {title: 'Year', titleTextStyle: {color: 'red'}},
                            axisTitlesPosition: "none",
                            pointSize: 2
                        };

                        var chart = new google.visualization.ChartWrapper({
                            'chartType': 'ScatterChart',
                            'containerId': 'scatterchart_div',
                            'options': options,
                        });

                        dashboard.bind(rangeSlider, chart);

                        dashboard.draw(data);
                        break;
                }
            }
        </script><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Global</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">America</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Brazil</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">USA</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Europe</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">France</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Germany</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">UK</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Asia</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">China</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Japan</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Mongolia</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Israel</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Iran</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Pakistan</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Australia</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Africa</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">Egypt</div></div><div style="position: absolute; display: none;"><div style="background:infobackground;color:infotext;padding:1px;border:1px solid infotext;fontSize:12px;fontFamily:Arial;">S. Africa</div></div>
    </body>
</html>