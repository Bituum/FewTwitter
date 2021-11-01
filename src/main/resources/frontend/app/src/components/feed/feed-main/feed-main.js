import React, {Component} from "react";
import './feed-main.css';
import axios from 'axios';
import {findByDisplayValue} from "@testing-library/react";

class FeedMain extends Component {
    state = {
        posts: [],
        users: []
    }

    componentDidMount() {
        axios
            .get('http://127.0.0.1:8080/user')
            .then((res) =>
                this.setState(
                    {
                        users: res.data
                    },
                    () =>
                        axios
                            .get(
                                'http://127.0.0.1:8080/post/all'
                            )
                            .then((res) => {
                                this.setState({
                                    posts: res.data
                                })
                            })
                )
            )
            .catch((err) => console.log(err))

    }

    render() {
        const {users} = this.state.users;
        console.log(this.state);
        // const userList = users.length ? (
        //     users.map(user => {
        //         return (
        //             <div className="postList" key={user.id}>
        //             <div className='content'>
        //                 <div className="window">
        //                     <div className="userLogin">
        //
        //                     </div>
        //                     <h3>{user.userPostList.commentSection}</h3>
        //                 </div>
        //
        //             </div>
        //
        //         </div>)
        //     })
        // ) : (
        //
        //     <div className="noPosts">
        //         <p>No posts et!</p>
        //     </div>
        // )
        const posts = this.state.posts;
        const userList = this.state.users;
        return (
            <div className='mainFeed'>
                <div className='modalWindow'>
                    <div className="wr">
                        {userList.map((user) =>{
                            console.log("propshel");

                            return(
                                posts.map((post) =>{
                                    console.log("propshel2");
                                    return (
                                        <div className="postList" key={user.id}>
                                            <div className="content">
                                                <div className="window">
                                                    <div className="userLogin">
                                                        <div className="userLogin">
                                                            <h1>{user.login}</h1>
                                                            <h3>{post.commentSection}</h3>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    );
                                })
                            );
                            })
                        }
                    </div>
                </div>
            </div>

        )
    }
}

// {posts.map((post) =>{
//     return(
//         <div className="postList" key={user.id}>
//             <div className="content">
//                 <div className="window">
//                     <div className="userLogin">
//                         <h1>{user.login}</h1>
//                         <h3>{post.commentSection}</h3>
//                     </div>
//                 </div>
//             </div>
//         </div>
//     );})

export default FeedMain;