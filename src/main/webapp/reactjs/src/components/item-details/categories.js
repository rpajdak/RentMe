

class FetchItemsDetails extends React.Component {
    state = {
        loading: true,
        person: null
    };

    async componentDidMount() {
        const url = "http://localhost:8080/api/items/all";
        const response = await fetch(url);
        const data = await response.json();
        this.setState({ person: data.results[0], loading: false });
    }

    render() {
        if (this.state.loading) {
            return <div>loading...</div>;
        }

        if (!this.state.person) {
            return <div>didn't get a person</div>;
        }

        return (

            <div>
                <div>{this.state.person.name.title}</div>
                <div>{this.state.person.name.first}</div>
                <div>{this.state.person.name.last}</div>
                <img src={this.state.person.picture.large} />
            </div>



        );


    }





}