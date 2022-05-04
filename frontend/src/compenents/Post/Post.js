import React, { useState, useEffect } from "react";
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardContent from '@mui/material/CardContent';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';

function Post(props) {
    const { title, text } = props;
    return (

        <div>
            <Card sx={{ maxWidth: 345 }}>
                <CardHeader
                    avatar={
                        <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
                            R
                        </Avatar>
                    }
                    
                    title={title}
                    text={text}
                />
                
                <CardContent>
                    <Typography variant="body2" color="text.secondary">
                        yazı
                    </Typography>
                </CardContent>
                
            </Card>
            {title}
            {text}
        </div>
    );

}
export default Post;