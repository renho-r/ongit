<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <table class="table">
            <thead>
                <th></th>
                <th>name</th>
                <th>path</th>
                <th>action</th>
            </thead>
            <tbody id="showTb">

            </tbody>
        </table>
    </div>
    <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script>
        $(function() {
            $.ajax({
                type: "GET",
                url: "res/list",
                dataType: "json",
                success: function(data){
                    for(let res in data) {
                        $("#showTb").append(
                            "<tr><td><span class='"
                            + ("1"==data[res].type? "glyphicon glyphicon-file": "glyphicon glyphicon-folder-open")
                            + " aria-hidden='true'></span>"
                            + "</td><td>"
                            + data[res].name
                            + "</td><td>"
                            + data[res].path
                            + "</td>"
                            + "<td>"
                            + ("1"==data[res].type? "<a href='res/download?file=" + data[res].path + "' ><span name='downLoadFile' class='glyphicon glyphicon-save-file' aria-hidden='true'></span></a>": "")
                            + "</td>"
                            + "</tr>");
                    }
                }
            });
        });
</script>
</body>
</html>