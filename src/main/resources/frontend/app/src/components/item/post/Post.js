import React from "react";
import "./post.css";


const Post = (props) => {
    return (
        <div className="post">
            <h1>{props.name}</h1>
            <h1>{props.post}</h1>
        </div>
    );
}

export default Post;