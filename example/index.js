import React, {Component} from "react";
import {
  StyleSheet,
  Text,
  View,
} from "react-native";
import SplashScreen from "rn-splash-screen";

export default class Example extends Component {
  state = {
    isLoading: true,
  };

  componentDidMount() {
    global.setTimeout(() => {
      this.setState({isLoading: false});
    }, 1000);
  }

  componentDidUpdate() {
    if (!this.state.isLoading) {
      // Hide splash screen
      SplashScreen.hide();
    }
  }

  render() {
    if (this.state.isLoading) return null;

    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  welcome: {
    fontSize: 20,
    textAlign: "center",
    margin: 10,
  },
});
