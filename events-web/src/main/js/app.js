'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
const Popup = require('react-popup');


// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
	}


	render() {
	    const events = this.props.events;
	    if(events.length==0){
          return <h2>No events found</h2>;
        }else{
            return (
                <EventsList events={events}/>
            );
    	}
	}
}



class EventsList extends React.Component{
	render() {
		var events = this.props.events.map(event =>
			<Event key={event.id} event={event}/>
		);

		return (
			<table>
				<tbody>
					<tr>
						<th>Title</th>
						<th>Address</th>
						<th>Date</th>
					</tr>
					{events}
				</tbody>
			</table>
		)
	}
}

class Event extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.event.title}</td>
				<td>{this.props.event.venue_address}</td>
				<td>{this.props.event.start_time}</td>
			</tr>
		)
	}
}

class SearchForm extends React.Component {
  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleChangeDate = this.handleChangeDate.bind(this);
    this.state = {value: '', events: [], startDate: null, endDate: null};
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleInputChange(event) {
      const target = event.target;
      const value = target.type === 'checkbox' ? target.checked : target.value;
      const name = target.name;

        this.setState({
        [name]: value
      });
  }

  handleChangeDate(event) {
    if(event.target.value === ''){
        this.setState({[event.target.name]: null});
    }else{
        const d = new Date(event.target.value);
        const dt=("0" + d.getDate()).slice(-2);
        const mm=("0" + (d.getMonth() + 1)).slice(-2);
        const yy=d.getFullYear();

        this.setState({[event.target.name]: yy+''+mm+''+dt+'00'});
    }
  }

  handleSubmit(event) {
    const location = this.state.value;
    const startDate = this.state.startDate;
    const endDate = this.state.endDate;



        var filter = '';
        var url = 'http://localhost:8080/events/' + location;

        const separator = ',';
          if(this.state.music){
            if(filter != '') filter = filter + separator;
            filter = filter + 'music';

          }
          if(this.state.sport){
            if(filter != '') filter = filter + separator;
            filter = filter + 'sport';

          }
          if(this.state.comedy){
            if(filter != '') filter = filter + separator;
            filter = filter + 'comedy';
          }
          if(this.state.family_fun_kids){
            if(filter != '') filter = filter + separator;
            filter = filter + 'family_fun_kids';
          }
          if(this.state.performing_arts){
            if(filter != '') filter = filter + separator;
            filter = filter + 'performing_arts';
          }

        if(filter != ''){
          url = url + '&categories=' + filter;
        }

        if(startDate !=null && endDate !=null){
            url = url + '&date=' + startDate + '-' + endDate;
        }

    if(startDate != null && endDate ==null){
        alert('Please choose end date');
    }else if(startDate == null && endDate !=null){
        alert('Please choose start date');
    }else{
        client({method: 'GET', path:  url }).done(response => {
            this.setState({value: location, events: response.entity});
        });
    }
    event.preventDefault();
  }

  render() {
    const value = this.state.value;
    return (
      <fieldset>
        <legend>Enter your event location:</legend>

          <form onSubmit={this.handleSubmit}>
            <label>
              <input type="search" value={this.state.value} onChange={this.handleChange} placeholder="Locaion..." required/>
            </label>
            <input type="submit" value="Search" />

            <div>
                <input type="checkbox" name="music" value="music" onChange={this.handleInputChange} />Music
                <input type="checkbox" name="sport" value="sport" onChange={this.handleInputChange} />Sport
                <input type="checkbox" name="comedy" value="comedy" onChange={this.handleInputChange} />Comedy
                <input type="checkbox" name="family_fun_kids" value="family_fun_kids" onChange={this.handleInputChange} />Family
                <input type="checkbox" name="performing_arts" value="performing_arts" onChange={this.handleInputChange} />Performing arts
            </div>

            <div>
                    From <input type="date" name="startDate"  onChange={this.handleChangeDate} />
                    To <input type="date" name="endDate"  onChange={this.handleChangeDate} />
            </div>


          </form>


        <App events={this.state.events} />
      </fieldset>
    );
  }
}




ReactDOM.render(
  <SearchForm />,
  document.getElementById('react')
);