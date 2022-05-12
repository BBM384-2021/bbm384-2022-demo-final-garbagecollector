import React, { useState, useEffect } from "react";
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardContent from '@mui/material/CardContent';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import { useHistory } from "react-router";

import { red } from '@mui/material/colors';
import './Admin.css';
function Admin(props) {
    let history = useHistory();
    const { name, id } = props;
    const [enable, setEnable] = useState(false)

    const enableUser =  () => {
        if (enable == true) {
            const requestOptions = {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                params: { id: id },
            };
             fetch("http://localhost:8080/admin/enable/?userId=" + id, requestOptions)
            console.log(id);
            history.go(0)
        }


    };

    return (

        <Card className="Card">
            <CardHeader
                avatar={
                    <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
                        R
                    </Avatar>
                }

                title={name}
            />
            <button onClick={() => { setEnable(true); enableUser(id);}}>Enable</button>
            <CardContent>
                <Typography variant="body2" color="text.secondary">
                    {id}

                </Typography>
            </CardContent>


        </Card>

    );

}
export default Admin;