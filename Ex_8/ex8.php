<!DOCTYPE html>
<html>
<head>
    <title>Indian Cuisine</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
            background-color:#39e75f;
        }

        th, td {
            padding: 8px;
            text-align: left;
            font-weight: bold;
            font-size:20px
        }

        th {
            background-color: #00DDFF;
        }

        ul {
            list-style-type: square;
        }
    </style>
</head>
<body >
    <h1>Indian Cuisine</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Dish</th>
            <th>Main Ingredients</th>
            <th>Region</th>
            <th>Popular Pairings</th>
        </tr>
        <?php
            // Load the XML file
            $xml = simplexml_load_file('ex8.xml');

            // Check if the XML file was successfully loaded
            if ($xml) {
                // Loop through each dish and display its information
                foreach ($xml->dish as $dish) {
                    echo "<tr>";
                    echo "<td>" . $dish->name . "</td>";
                    echo "<td>" . $dish->type . "</td>";
                    echo "<td>" . $dish->ingredients . "</td>";
                    echo "<td>" . $dish->region . "</td>";
                    
                    echo "<td>";
                    echo "<ul>";
                    foreach ($dish->pairings->pairing as $pairing) {
                        echo "<li>" . $pairing . "</li>";
                    }
                    echo "</ul>";
                    echo "</td>";
                    echo "</tr>";
                }
            } else {
                echo "<tr><td colspan='5'>Failed to load the XML file.</td></tr>";
            }
        ?>
    </table>
</body>
</html>
