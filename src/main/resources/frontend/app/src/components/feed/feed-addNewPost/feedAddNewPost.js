import React, {Component} from "react";
import './feedAddNewPost.css'

class AddNewPost extends Component{


    render() {
        return(
            <div className="addPost">
                <button className="addPostButton">
                    add post
                </button>
            </div>
        );
    }
}

export default AddNewPost;