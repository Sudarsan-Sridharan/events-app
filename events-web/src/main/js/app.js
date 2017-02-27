'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {events: []};
	}

	componentDidMount() {
		client({method: 'GET', path: 'http://localhost:8080/events/Brighton'}).done(response => {
			this.setState({events: response.entity});
		});
	}

	render() {
		return (
			<EventsList events={this.state.events}/>
		)
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



ReactDOM.render(
  <App />,
  document.getElementById('react')
);