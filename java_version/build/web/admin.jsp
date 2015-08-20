<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin user login</title>

    <!-- Bootstrap Core CSS -->
    <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Weclome admin ${username}</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="index.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="admin.jsp"><i class="fa fa-table fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> DB operatoin<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="insert.jsp">Insert new data</a>
                                </li>
                                <li>
                                    <a href="delete.jsp">delete old data</a>
                                </li>
                                <li>
                                    <a href="search.jsp">search data</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                                <tr>
                                                    <th>ReferenceType</th>
                                                    <th>Record_Number</th>
                                                    <th>Author</th>
                                                    <th>Year</th>
                                                    <th>Journal</th>
                                                    <th>Volume</th>
                                                    <th>Issue</th>
                                                    <th>Pages</th>
                                                    <th>Short_Title</th>
                                                    <th>Alternate_Journal</th>
                                                    <th>ISSN</th>
                                                    <th>PMCID</th>
                                                    <th>Accession_Number</th>
                                                    <th>Abstract</th>
                                                    <th>Notes</th>
                                                    <th>URL</th>
                                                    <th>Author_Address</th>
                                                    <th>id</th>
                                                    
                                                    
                                                </tr>
                                                    <s:iterator value="arr">
                                                        <tr>
                                                        <td>
                                                            <s:property value = "ReferenceType"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Record_Number"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Author"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Year"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Journal"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Volume"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Issue"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Pages"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Short_Title"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Alternate_Journal"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "ISSN"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "PMCID"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Accession_Number"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Abstract"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Notes"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "URL"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "Author_Address"/>
                                                        </td>
                                                        <td>
                                                            <s:property value = "id"/>
                                                        </td>

                                                        </tr>
                                                    </s:iterator>
                                                
                                        </table>  
                                    </div>
                                    <!-- /.table-responsive -->
                               
                                <!-- /.col-lg-4 (nested) -->
                                <div class="col-lg-8">
                                    <div id="morris-bar-chart"></div>
                                </div>
                                <!-- /.col-lg-8 (nested) -->
                          
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="bower_components/raphael/raphael-min.js"></script>
    <script src="bower_components/morrisjs/morris.min.js"></script>
    <script src="js/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
