import React, { useState, useEffect } from "react";
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardContent from '@mui/material/CardContent';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import { useHistory } from "react-router";

import { red } from '@mui/material/colors';
import './Post.css';
function Post(props) {
    let history = useHistory();
    const { name, id } = props;
    const [enable, setEnable] = useState(false)

   

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
            <CardContent>
                <Typography variant="body2" color="text.secondary">
                    {id}

                </Typography>
            </CardContent>


        </Card>

    );

}
export default Post;