<!DOCTYPE html>
<html>

<head>
    <title>FlyAway</title>
    <link rel="stylesheet" type="text/css" href="index.css" media="all" />
</head>

<body>
    <div>
        <table class="banner">
            <tr>
                <th width=40%><img src="https://freepngimg.com/thumb/airplane/26315-7-airplane-transparent.png" width="240px" /></th>
                <th width="20%">
                    <h1>FlyAway</h1>
                </th>
            </tr>
        </table>
    </div>
    <p>Fill out the following form to find a flights that matches your schedule</p>
    <div>
        <form action="flightlist" method="POST">
            <p>Please select the date you would like to book for : <input id="date" autofocus="autofocus" type="date" name="book_date" id="book_date"  min="2021-09-01" max="2021-10-31" />
            </p>
            <p>Source:
                <select name="source_country" class="form-control">
                    <option value="China">China</option>
                    <option value="India">India</option>
                    <option value="United States">United States</option>
                </select>
                Destination:
                <select id="country" name="destination_country" class="form-control">
                    <option value="China">China</option>
                    <option value="India">India</option>
                    <option value="United States">United States</option>
                </select>
            </p>
            <p>Number of passengers: <input type="number" name="n_pass" min="1"/>
            </p>
            <p>
                <input type="submit" value="Submit form" />
                <input type="reset" value="Reset form" />
            </p>
        </form>
    </div>


</body>

</html>