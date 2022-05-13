import {React, useState, useEffect} from "react";
import {useParams} from "react-router-dom";
import Avatar from "../Avatar/Avatar";
import UserActivity from "../UserActivity/UserActivity";
import { makeStyles } from '@material-ui/core/styles';
import {DeleteWithAuth, GetWithAuth, PostWithoutAuth} from "../../services/HttpService";
import Text from "../Text/Text";
import Follow from "../Follow/Follow";

const useStyles = makeStyles({
    root: {
        display: "flex",
    },

        container: {
            display: "flex",
            flexWrap: "wrap",
            justifyContent : "center",
            alignItems : "center",
            backgroundColor: '#ffffff',
        },
        textStyle: {
            width: '55ch',
        }

});

function User() {
    const { userId} = useParams();
    const classes = useStyles();
    const [user, setUser] = useState();
    const [isFollowing, setIsFollowing] = useState(false);
    const [followId, setIsFollowingId] = useState(null);

    console.log("User id from userParams(): " + userId);

    const getUser = () => {
        GetWithAuth("http://localhost:8080/users/"+userId)
            .then(res => res.json())
            .then(
                (result) => {
                    setUser(result);
                    console.log("Result: " + result);
                },
                (error) => {
                    console.log(error)
                }
            )
    }

    const getIsFollow = () => {
        GetWithAuth("http://localhost:8080/follows/?senderUserId="
            + localStorage.getItem("currentUser") + "&receiverUserId=" + userId)
            .then(res => res.json())
            .then((result) => {
                    setIsFollowing(result.followed);
                    setIsFollowingId(result.id);
                    console.log("FOLLOW: " + result + " " + result.id + " " + result.followed);
                }
            ).catch((err) => console.log(err))
    }

    const sendFollow = () => {
        PostWithoutAuth("http://localhost:8080/follows/",
            {
                senderUserId: localStorage.getItem("currentUser"),
                receiverUserId: userId
            })
    }

    const deleteFollow = () => {
        DeleteWithAuth("http://localhost:8080/follows/" + followId)
    }

    const handleFollow = () => {
        if(!isFollowing) {
            sendFollow();
            setIsFollowing(true);
        } else {
            deleteFollow();
            setIsFollowing(false);
            setIsFollowingId("");
        }
    }

    useEffect(() => {
        getUser()
    }, [])

    useEffect(() => {
        console.log("follow yenileniyor...")
        getIsFollow()
    }, [isFollowing, followId])

    return(
        <div className={classes.root}>
            {user? <Avatar avatarId={user.avatar} userId={userId} userName={user.userName}/> : "" }
            <div className={classes.container}>
                {user? (localStorage.getItem("currentUser") == userId
                        ? <Text userName={user.userName} userEmail={user.email} userId={userId}/>
                    :
                        <Follow userId={userId} isFollowing={isFollowing} click={handleFollow} getIsFollow={getIsFollow}/>
                ) : ""}
                <UserActivity userId={userId} />
            </div>
        </div>
    )
}

export default User;

//<Follow userId={userId} user={user} />