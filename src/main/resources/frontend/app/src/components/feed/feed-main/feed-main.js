import React, {Component} from "react";
import './feed-main.css';
import axios from 'axios';
import UserContentComponent from "./UserContent/UserContentComponent";


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

    ifArrayIsNotEmpty() {

    }

    render() {
        const {users} = this.state.users;
        console.log(this.state);
        const userList = this.state.users;
        return (
            // <div className='mainFeed'>
            //     <div className='modalWindow'>
            //         <div className="wr">
            //             {userList.map((user, index) => {
            //             return(
            //                 <div key={index}>
            //                     <div className="postList" key={user.id}>
            //                         <div>{user.userPostList.length > 0 ? user.login : ""}</div>
            //                         <div>{user.userPostList.length > 0 ? user.userPostList.map((post) =>{
            //                             {
            //                                 return(
            //                                     <div className="content">
            //                                         <div className="window">
            //                                             <UserContentComponent
            //                                                 username={user.login}
            //                                                 commentContent={post.commentSection}/>
            //                                         </div>
            //                                     </div>
            //
            //                                 );
            //                             }
            //                         }) : ""}</div>
            //                     </div>
            //                     </div>
            //
            //             );
            //
            //                 })
            //             }
            //         </div>
            //     </div>
            // </div>
            <div className="mainFeed">
                {userList.map((user, index) => {
                    return (
                        <div key={index}>
                            <div className="secondFeed" key={user.id}>
                                <div
                                    className="secondFeedIteration">{user.userPostList.length > 0 ? user.userPostList.map((post) => {
                                    {
                                        return (
                                            <div className="content">
                                                <UserContentComponent
                                                    username={user.login}
                                                    commentContent={post.commentSection}/>
                                            </div>
                                        );
                                    }
                                }) : null}</div>
                            </div>
                        </div>)
                })}
            </div>
        );
    }
}
export default FeedMain;