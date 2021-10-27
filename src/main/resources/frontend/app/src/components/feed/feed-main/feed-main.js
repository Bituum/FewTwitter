import React, {Component} from "react";
import './feed-main.css';
import axios from 'axios';

class FeedMain extends Component {
    state = {
        posts: []
    }

    componentDidMount() {
        axios.get('http://127.0.0.1:8080/post/all')
            .then(result => {
                console.log(result.data)
                this.setState({
                    posts: result.data.slice(1,10)
                })
            })
            .catch(error => {
                console.log("Error", error);
            })
    }


    render() {
        const {posts} = this.state;
        const postsList = posts.length ? (
            posts.map(post => {
                return (<div className="postList" key={post.id}>
                    <div className='content'>
                        <div className="window">
                            <h3>{post.commentSection}</h3>
                        </div>

                    </div>

                </div>)
            })
        ) : (

            <div className="noPosts">
                <p>No posts et!</p>
            </div>

        )
        return (
            <div className='mainFeed'>
                <div className='modalWindow'>
                    <div className="wr">
                        {postsList}
                    </div>
                </div>
            </div>

        )
    }
}

export default FeedMain;