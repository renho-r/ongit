<?php
	#$url = $_POST['url'];
	#$url = 'http://www.guokr.com/apis/minisite/article.json?retrieve_type=by_subject&limit=20&offset=39&_=1433906390606';
	#$url = 'http://www.163.com';
	#$url = 'http://localhost:8080/NetXpert/aidns/jsps/configManage/configTemplet.jsp';
    #$ret = file_get_contents($url);
    
    $ch = curl_init();
    #curl_setopt($ch, CURLOPT_URL, "http://www.guokr.com/apis/minisite/article.json?retrieve_type=by_subject&limit=20&offset=39&_=1433906390606");
    curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/NetXpert/aidns/jsps/configManage/configTemplet.jsp");
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($ch, CURLOPT_HEADER, 0);

	$a = curl_exec($ch);
	curl_close($ch);

    echo $a;