<html>
<body>
    <form id="form-test" method="post" action="">
        <input type="button" id="getUser" onclick="exec(this)" value="/user/manage/getUsers"/>
        <br>
        <input type="button" id="insertUser" onclick="exec(this)" value="/user/manage/insertUsers"/>
    </form>
</body>

<script src="/res/statistics/jquery-3.3.1.js"></script>
<script>
    function exec(e) {
        document.getElementById("form-test").action = e.value;
        document.getElementById("form-test").submit();
    }
</script>
</html>
