import React, {Component} from "react";
import axios from "axios";


class UsenameGetComponent extends Component{
    state = {
        users: []
    }

    componentDidMount() {
        axios.get('http://127.0.0.1:8080/user')
            .then(result => {
                console.log(result.data)
                this.setState({
                    users: result.data
                })
            })
    }

    render() {
        return(
            <div className="username">

            </div>
        );
    }
}