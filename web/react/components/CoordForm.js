import {Slider} from 'primereact/components/slider/Slider';
import {Panel} from 'primereact/components/panel/Panel';
var React = require('react');
var ReactDOM = require('react-dom');


class CoordForm extends React.Component{

    constructor(props){
        super(props);
        this.state={x: props.x, y: props.y, r: props.r, xIsValid: this.validateX(props.x), yIsValid: this.validateY(props.y), rIsValid: this.validateR(props.r)};
        this.onXChange = this.onXChange.bind(this);
        this.onYChange = this.onYChange.bind(this);
        this.onRChange = this.onRChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.validateX = this.validateX.bind(this);
        this.validateY = this.validateY.bind(this);
        this.validateR = this.validateR.bind(this);
    }

    handleSubmit(e) {
        if (!this.state.xIsValid){
            e.preventDefault();
            alert("X coordinate value must be between -5 and 5");
        }
        if (!this.state.yIsValid){

            alert("Y coordinate value must be between -3 and 5");
        }
        if (!this.state.rIsValid){
            e.preventDefault();
            alert("R coordinate value must be between 0 and 5");
        }

        e.preventDefault();
        alert("Submitted");

        var http_request = new XMLHttpRequest();
        if (window.XMLHttpRequest) {
            http_request = new XMLHttpRequest();
        }
        http_request.open('POST', "check", true);
        http_request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        var body = "x="+this.state.x+"&y="+this.state.y+"&r="+this.state.r;
        http_request.send(body);
        /*http_request.onreadystatechange = function () {
            if(http_request.readyState === XMLHttpRequest.DONE && http_request.status === 200) {
                if (http_request.responseText === "true"){
                    this.setState({usrExists: true});
                }
                else {
                    this.setState({usrExists: false});
                }
            }
        }.bind(this);*/
    }
    validateX(x){
        return (x >= -5 && x <= 5);
    }

    validateY(y){
        return (y >= -3 && y <= 5);
    }

    validateR(r){
        return (r >= 0 && r <= 5)
    }

    onXChange(e){
        var val = e.target.value;
        this.setState({x: val, xIsValid: this.validateX(val)})
    }

    onYChange(e){
        var val = e.target.value;
        this.setState({y: val, yIsValid: this.validateY(val)})
    }
    onRChange(e){
        var val = e.target.value;
        this.setState({r: val, rIsValid: this.validateR(val)})
    }
    render(){
        return(
                <div className="row form-container">
                    <div className="col-sm-6 col-sm-offset-2">
                        <h3>Enter point coordinates</h3>
                        <form role="form" id="contactForm"  onSubmit={this.handleSubmit}>
                            <div className="form-group">
                                <label htmlFor="x" className="h4">X coordinate</label>
                                <input type="text" className="form-control" id="x"  placeholder="Enter x" value={this.state.x} onChange={this.onXChange} title="Only numbers between -5 and 5 are allowable"  pattern="-?\d+(\.\d+)?" required/>
                                <label htmlFor="y" className="h4">Y coordinate</label>
                                <input type="text" className="form-control" id="y" placeholder="Enter y" value={this.state.y} onChange={this.onYChange} title="Only numbers between -3 and 5 are allowable"  pattern="-?\d+(\.\d+)?" required/>
                                <label htmlFor="r" className="h4">Radius</label>
                                <input type="text" className="form-control" id="r" placeholder="Enter R" value={this.state.r} onChange={this.onRChange} title="Only numbers between 0 and 5 are allowable" pattern="\d+(\.\d+)?" required/>
                            </div>
                            <button id="submit" type="submit" className="submit pull-right" value="Submit">Submit</button>

                        </form>
                    </div>
                </div>
        )
    }
}

ReactDOM.render(
    //<SliderDemo/>,
    <CoordForm x="" y="" r=""/>,
    document.getElementById("right-column")
);

export default CoordForm;
//export default SliderDemo;