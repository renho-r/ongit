<?php
	function __autoload($class){
		require_once "$class.class.php";
	}
	
	$method = $_GET['method'];
	
	$method();
	
	function queryAllAsArray() {
		$conn = DBUtil :: getConn();
		$start = $_GET['start'];
		$length = $_GET['length'];
		$result = $conn->query ( "select USERID, LOGINNAME, LOGINPWD, USERNAME, EMAIL, PHONE, USERDESC from com_user limit $start, $length" );
		$i = 0;
		while ( $row = mysqli_fetch_assoc ( $result ) ) {
			$responce->data[$i][0] = $row['USERID'];
			$responce->data[$i][1] = $row['LOGINNAME'];
			$responce->data[$i][2] = $row['LOGINPWD'];
			$responce->data[$i][3] = $row['USERNAME'];
			$responce->data[$i][4] = $row['EMAIL'];
			$responce->data[$i][5] = $row['PHONE'];
			$responce->data[$i][6] = $row['USERDESC'];
			$i++;
		}
		DBUtil :: close($result, $conn);
		$conn = DBUtil :: getConn();
		$result = $conn->query ( "select COUNT(1) C from com_user" );
		$row = mysqli_fetch_row($result);
		
		$responce->recordsTotal = $row[0];
		$responce->recordsFiltered = $row[0];
		DBUtil :: close($result, $conn);
		echo json_encode($responce);		
	}
	
	function queryAllAsJson() {
		$conn = DBUtil :: getConn();
		$start = $_GET['start'];
		$length = $_GET['length'];
		$order = $_GET['order'][0]['fieldName'];
		$orderType = $_GET['order'][0]['dir'];
		$result = $conn->query ( "select USERID, LOGINNAME, LOGINPWD, USERNAME, EMAIL, PHONE, USERDESC from com_user order by $order $orderType limit $start, $length" );
		$i = 0;
		while ( $row = mysqli_fetch_assoc ( $result ) ) {
			$responce->data[$i]['USERID'] = $row['USERID'];
			$responce->data[$i]['LOGINNAME'] = $row['LOGINNAME'];
			$responce->data[$i]['LOGINPWD'] = $row['LOGINPWD'];
			$responce->data[$i]['USERNAME'] = $row['USERNAME'];
			$responce->data[$i]['EMAIL'] = $row['EMAIL'];
			$responce->data[$i]['PHONE'] = $row['PHONE'];
			$responce->data[$i]['USERDESC'] = $row['USERDESC'];
			$i++;
		}
		DBUtil :: close($result, $conn);
		$conn = DBUtil :: getConn();
		$result = $conn->query ( "select COUNT(1) C from com_user" );
		$row = mysqli_fetch_row($result);
		
		$responce->recordsTotal = $row[0];
		$responce->recordsFiltered = $row[0];
		DBUtil :: close($result, $conn);
		echo json_encode($responce);
	}