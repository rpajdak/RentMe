import React from "react";

export default class FetchDetails extends React.Component {
    state = {
        loading: true,
        name: null
    };

    categoryList(){
        const listItems = this.state.name.map((number) => <option>{number}</option>
        )
        return listItems;
    }

    async componentDidMount() {
        let categories = [];
        const url = "http://localhost:8080/api/items/{id}";
        const response = await fetch(url);
        const data = await response.json();

    }

    render() {
        if (this.state.loading) {
            return <div>loading...</div>;
        }

        if (!this.state.name) {
            return <div>Some problem occurred</div>;
        }

        return (
            this.categoryList()
        );
    }

}
