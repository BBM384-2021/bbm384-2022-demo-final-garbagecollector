import React, { useState, useEffect } from "react";
import Post from '../Post/Post';
import Container from '@mui/material/Container';
function Home() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [userList, setPostList] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/user", {
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
                    {userList.map((user) =>
                        <Post name={user.productName} price={user.unitPrice}></Post>
                    )}
                </Container>
            

        )
    }

}

export default Home;