import {React, useState, useEffect} from "react";
import {useParams} from "react-router-dom";
import UserActivity from "../UserActivity/UserActivity";
import { makeStyles } from '@material-ui/core/styles';
import {PostWithoutAuth, DeleteWithAuth, GetWithAuth} from "../../services/HttpService";
import Button from '@mui/material/Button';

function Follow(props){
    const {userId, isFollowing, click} = props;

    return(<div>
        {isFollowing? <Button variant="contained" onClick={click} color="error">Unfollow</Button>
                : <Button variant="contained" onClick={click} color="success" >Follow</Button>}
        </div>
    );
}

export default Follow;
