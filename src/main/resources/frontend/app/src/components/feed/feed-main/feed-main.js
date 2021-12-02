import React, {Component} from "react";
import './feed-main.css';
import axios from 'axios';
import ItarebleUserComponent from "./ItarebleUserComponent/ItarebleUserComponent";


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
        const unsortedUserList = this.state.users;

        function shuffleArray(unsortedUserList) {
            let i = unsortedUserList.length - 1;
            for (; i > 0; i--) {
                const j = Math.floor(Math.random() * (i + 1));
                const temp = unsortedUserList[i];
                unsortedUserList[i] = unsortedUserList[j];
                unsortedUserList[j] = temp;
            }
            return unsortedUserList;
        }

        const userList = shuffleArray(unsortedUserList);
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
                {userList.map((user) => {
                    return (
                        <div>
                            {user.userPostList.length > 0 ? <ItarebleUserComponent user={user}/> : null}
                        </div>
                    )
                })}
            </div>
        );
    }
}
export default FeedMain;