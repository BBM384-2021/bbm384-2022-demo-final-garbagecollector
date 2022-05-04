import React, { useState, useEffect } from "react";
import Post from '../Post/Post';
function Home() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [userList, setPostList] = useState([]);
    const [TotalReactPackages, setTotalReactPackages] = useState(null);

    /* useEffect(() => {
        // GET request using fetch inside useEffect React hook
        fetch('http://localhost:8080/user',
            {
                method: "GET",
                mode: "no-cors",
            })
            .then(response => response.json())
            .then(user => setTotalReactPackages(user.id));

        // empty dependency array means this effect will only run once (like componentDidMount in classes)
    }, []);
    return (
        <div>
            {TotalReactPackages}
        </div>
    ); */
    useEffect(() => {
        fetch("http://localhost:8080/user",{
            mode:"no-cors"
        })
            .then(res => res.json())
            .then(
                (result) => {
                    setIsLoaded(true);
                    setPostList(result);
                    console.log(result);

                }, (error) => {
                    setIsLoaded(true);
                    setError(error);
                    console.log(error);
                })
    }, [])
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
            <div className='container'>
                Home
                {userList.map(user => {
                    <Post title={user.id}></Post>
                })}
            </div>

        )
    }

}

export default Home;