<?php
	class DBUtil {
		
		const dbhost = "127.0.0.1:3306";
		const dbuser = "root";
		const dbpassword = "root123";
		const dbname = "dnsdb60";
		
		public static function getConn() {
			$conn = new mysqli (self :: dbhost, self :: dbuser, self :: dbpassword, self :: dbname );
			return $conn;
		}
		public static function close($result, $conn) {
			mysqli_free_result( $result );
			mysqli_close ( $conn );
		}
	}