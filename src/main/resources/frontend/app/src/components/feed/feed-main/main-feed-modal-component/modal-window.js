import React, { Component } from "react";

import './modal-window.css';
import axios from 'axios';

class ModalWindow extends Component {
    state ={
        posts :[]
    }

    componentDidMount(){
        axios.get('http://127.0.0.1:8080/post/all')
        .then(result => {
            console.log(result.data)
            this.setState({
                posts: result.data
            })
        })
        .catch(error => {
            console.log("Error",error);
        })
    }



    render(){
        const { posts } = this.state;
        const postsList = posts.length ? (
            posts.map(post =>{
                <div className="postList" key={post.id}>
                    {post.title}
                </div>
            })
        ) : (
            
                <div className="noPosts">
                    <p>No posts et!</p>
                </div>
            
        )
        
        return(
            <div className='modalWindow'>
                <div className='window'>
                    <div className="content"></div>    
                    {postsList}
                </div>
            </div>
        )
    }
}

export default ModalWindow;