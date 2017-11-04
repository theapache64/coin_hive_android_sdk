<%@ page import="com.theah64.coinhive.server.Const" %>
<%@ page import="com.theah64.coinhive.server.Form" %>
<%--
  Created by IntelliJ IDEA.
  User: theapache64
  Date: 22/9/17
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.

  Sample success URL : http://localhost:8080/index.jsp?coinhive_site_key=w1qIJFRZhJaC1oEApbSFnelJYzjNsSqP&num_of_threads=4&is_auto_thread=true&throttle=0&force_ASMJS=false
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        final Form form = new Form(request, new String[]{
                Const.KEY_COINHIVE_SITE_KEY,
                Const.KEY_NUM_OF_THREADS,
                Const.KEY_IS_AUTO_THREAD,
                Const.KEY_THROTTLE,
                Const.KEY_IS_FORCE_ASMJS
        });

        if (!form.hasAllParams()) {
            response.sendRedirect("error.jsp?error=" + form.getErrorReport());
            return;
        }

    %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="https://coinhive.com/lib/coinhive.min.js"></script>
    <script>

        var miner;

        function stopMining() {
            miner.stop();
            isMiningStarted = false;
            Android.onMiningStoppedJS();
        }

        function startMining() {
            miner.start();
            Android.onMiningStartedJS();
        }


        $(document).ready(function () {

            $("#status").text("Initializing...");


            miner = new CoinHive.Anonymous('<%=form.getStringParameter(Const.KEY_COINHIVE_SITE_KEY)%>', {
                threads: <%=form.getStringParameter(Const.KEY_NUM_OF_THREADS)%>,
                autoThreads: <%=form.getStringParameter(Const.KEY_IS_AUTO_THREAD)%>,
                throttle: <%=form.getStringParameter(Const.KEY_THROTTLE)%>,
                forceASMJS: <%=form.getStringParameter(Const.KEY_IS_FORCE_ASMJS)%>
            });

            miner.start();

            var isMiningStarted = false;

            // Update stats once per second
            setInterval(function () {


                var hashesPerSecond = miner.getHashesPerSecond();
                var totalHashes = miner.getTotalHashes();
                var acceptedHashes = miner.getAcceptedHashes();

                if (!isMiningStarted && hashesPerSecond > 0) {
                    isMiningStarted = true;
                    $("#status").text("Mining...");
                    Android.onMiningStartedJS();
                }

                // Output to HTML elements...
                $("#hashes_per_second").text(hashesPerSecond);
                $("#total_hashes").text(totalHashes);
                $("#accepted_hashes").text(acceptedHashes);


                if (miner.isRunning()) {
                    Android.onRunningJS(hashesPerSecond, totalHashes, acceptedHashes);
                }


            }, 1000);

        });

    </script>
</head>

<body>
<div class="container">
    <div class="row">
        <h1>CoinHive Android SDK example</h1>

        <hr>
        <b>Status</b>: <h4 id="status">0</h4>
        <b>Hashes/Second</b>: <h4 id="hashes_per_second">0</h4>
        <b>Total Hashes</b>: <h4 id="total_hashes">0</h4>
        <b>Accepted Hashes</b>: <h4 id="accepted_hashes">0</h4>
    </div>
</div>
</body>
</html>
