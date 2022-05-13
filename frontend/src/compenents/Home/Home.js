/*import React, { useState, useEffect } from "react";
import Post from '../Post/Post';
import Container from '@mui/material/Container';
import PostForm from "../Post/PostForm";
function Home() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [userList, setPostList] = useState([]);
    const [_title, setTitle] = useState("");
    const [_text, setText] = useState("");



    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            "Accept": 'application/json'
        },
        body: JSON.stringify({
            id: localStorage.getItem("currentUser"),
            title: _title,
            text: _text,

        })
    };
    


    useEffect(() => {
        fetch("http://localhost:8080/posts/?userId=3", {
        })
            .then(res => res.json())
            .then(
                (result) => {
                    setIsLoaded(true);
                    setPostList(result);


                }, (error) => {
                    setIsLoaded(true);
                    setError(error);
                    console.log(error);
                })
    }, [])

    const listItems = userList.map((user) =>
        <li>{user.id}</li>
    );
    if (error) {
        return (<div>error</div>)
    }
    else if (!isLoaded) {
        return (<div>
            Loading...
        </div>)
    }
    else {
        return (

            <Container fixed className="container">
                <PostForm userId={localStorage.getItem("currentUser")} userName={localStorage.getItem("userName")} refreshPosts={useEffect} />
                {userList.map((user) =>
                    <Post name={user.text} id={user.id}>
                    </Post>
                )}
            </Container>


        )
    }

}

export default Home;*/

import React, {useState, useEffect} from "react";
import Post from '../Post/Post';

import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import PostForm from "../Post/PostForm";

const useStyles = makeStyles((theme) => ({
    container: {
        display: "flex",
        flexWrap: "wrap",
        justifyContent : "center",
        alignItems : "center",
        backgroundColor: '#f0f5ff',
    }
}));

function Home() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [postList, setPostList] = useState([]);
    const classes = useStyles();


    const refreshPosts = () => {
        fetch("http://localhost:8080/posts")
            .then(res => res.json())
            .then(
                (result) => {
                    setIsLoaded(true);
                    setPostList(result.reverse())
                },
                (error) => {
                    console.log(error)
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }

    useEffect(() => {
        refreshPosts()
    }, [postList])

    if(error) {
        return <div> Error !!!</div>;
    } else if(!isLoaded) {
        return <div> Loading... </div>;
    } else {
        return(

            <div className = {classes.container}>
                {localStorage.getItem("currentUser") == null? "ERROR!!!!'!'!'!'!'!'!'":
                    <PostForm userId = {localStorage.getItem("currentUser")} userName = {localStorage.getItem("userName")}  refreshPosts = {refreshPosts}/>}
                {postList.map(post => (
                    <Post likes = {post.postLikes} postId = {post.id} userId = {post.userId} userName = {post.userName}
                          title={post.title} text={post.text}></Post>
                ))}
            </div>
        );
    }
}

export default Home;