<!DOCTYPE html>
<html lang="en">
<?php
    include "db_connect.php";
?>
<head>

    <meta charset="utf-8">

    <title>Welcome to Reference Search</title>

    <!-- DataTables -->
    <script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.3/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.3/js/jquery.dataTables.js"></script>
    
</head>

<body>
    <script type="text/javascript" language="javascript" class="init">
    $(document).ready(function() {
        $('.display').dataTable( {
            "pagingType": "full_numbers"
        } );
    } );
    </script>
    <table id="userTable" class="display" border="1" style="width:100%"> 
        <thead>
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

            </tr>
        </thead>
    <tbody>
    <?php 
            //if($_POST['search_input'] == "all"){
            if(1){ 
                $sql = "SELECT * FROM reference;";
                $event = $conn -> query($sql);
                if($event -> num_rows > 0){
                    while($row = $event -> fetch_assoc()){
                        echo "<tr><td>" . $row['ReferenceType'] . "</td>";
                        echo "<td>" . $row['Record_Number'] . "</td>";
                        echo "<td>" . $row['Author'] . "</td>";
                        echo "<td>" . $row['Year'] . "</td>";
                        echo "<td>" . $row['Journal'] . "</td>";
                        echo "<td>" . $row['Volume'] . "</td>";
                        echo "<td>" . $row['Issue'] . "</td>";
                        echo "<td>" . $row['Pages'] . "</td>";
                        echo "<td>" . $row['Short_Title'] . "</td>";
                        echo "<td>" . $row['Alternate_Journal'] . "</td>";
                        echo "<td>" . $row['ISSN'] . "</td>";
                        echo "<td>" . $row['PMCID'] . "</td>";
                        echo "<td>" . $row['Accession_Number'] . "</td>";
                        echo "<td>" . $row['Abstract'] . "</td>";
                        echo "<td>" . $row['Notes'] . "</td>";
                        echo "<td>" . $row['URL'] . "</td>";
                        echo "<td>" . $row['Author_Address'] . "</td></tr>";
                    
                    }
                }else{
                    echo "</br >no result";
                }
            }else{
                echo "no result";
            }
        ?>
    </tbody>
    </table>
                                
</body>

</html>
