
import {InputText} from 'primereact/components/inputtext/InputText';
var React = require('react');
class UserForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {name: ""};

        this.onChange = this.onChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    onChange(e) {
        var val = e.target.value;
        this.setState({name: val});
    }

    handleSubmit(e) {
        e.preventDefault();
        alert("Имя: " + this.state.name);
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <p>
                    <label>Имя:</label><br />
                    <input type="text" value={this.state.name} onChange={this.onChange}/>
                    <span className="ui-float-label">
                        <InputText id="float-input" type="text" size="30" />
                        <label htmlFor="float-input">Username</label>
                    </span>
                </p>
                <input type="submit" value="Отправить" />
            </form>
        );
    }
}
ReactDOM.render(
    <UserForm />,
    document.getElementById("app")
);