<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  <title>�����ǽ�  for yours</title>

    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- ��Ʈ��Ʈ�� CSS �߰��ϱ� -->

    <link rel="stylesheet" href="./css/bootstrap.min.css">

    <!-- Ŀ���� CSS �߰��ϱ� -->

    <link rel="stylesheet" href="./css/custom.css">
</head>
<body>

<style>
.go
{
float:left;
}
</style>
<div id="navbar" class="collapse navbar-collapse">
   			<ul class="navbar-nav mr-auto">
   			  			 	<li class="nav item active">
   						<a class="nav-link" href="index.jsp">����</a>
  			 	</li>
  			 	
   				 <li class="nav-item dropdown">
		           		 <a class="nav-link2 dropdown-toggle" id="dropdown" data-toggle="dropdown">
		              	ȸ�� ����
		            </a>
		            </li>
		            </ul>
		            </div>
		            

  <div class="container mt-3" style="max-width: 560px; ">
	
      <form method="post" action="./userLoginAction.jsp">

        <div class="form-group">

          <label>���̵�</label>
          <input type="text" name="userID" class="form-control">

        </div>

        <div class="form-group">

          <label>��й�ȣ</label>
          <input type="password" name="userPassword" class="form-control">
</div>
</form>



		
		<div class = "go" style=margin-right:20px;>
		<form method="post" action="./userRegisterAction.jsp">
		<ul class ="goes">
		<li class="dona">
		<button type="submit" class="btn btn-primary">�α���</button>
		</li>
		</ul>
		</div>
      </form>

	
		
     
		
	<ul>
	<li><form method="post" action="./userRegister.jsp">
		   <button type="submit" class="btn btn-primary">ȸ������</button>
		</form></li>

	</ul>
	
	
 <script src="./js/jquery.min.js"></script>

    <!-- Popper �ڹٽ�ũ��Ʈ �߰��ϱ� -->

    <script src="./js/popper.min.js"></script>

    <!-- ��Ʈ��Ʈ�� �ڹٽ�ũ��Ʈ �߰��ϱ� -->

    <script src="./js/bootstrap.min.js"></script>

</body>
</html>