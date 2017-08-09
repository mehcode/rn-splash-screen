import React, { Component } from "react";
import { StyleSheet, Text, View, TextInput } from "react-native";
import SplashScreen from "rn-splash-screen";

export default class Example extends Component {
  state = {
    isLoading: true
  };

  componentDidMount() {
    global.setTimeout(() => {
      this.setState({ isLoading: false });
    }, 1000);
  }

  componentDidUpdate() {
    if (!this.state.isLoading) {
      // Hide splash screen
      SplashScreen.hide();
    }
  }

  handlePress = () => {
    this.refs.input.blur();
  };

  render() {
    if (this.state.isLoading) return null;

    return (
      <View style={styles.container}>
        <Text style={styles.welcome} onPress={this.handlePress}>
          Welcome to React Native!
        </Text>
        <TextInput
          ref="input"
          style={styles.input}
          underlineColorAndroid="rgba(255, 255, 255, 0.5)"
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#252525",
    justifyContent: "center",
    alignItems: "center"
  },
  welcome: {
    color: "#fff",
    fontSize: 20,
    textAlign: "center",
    margin: 10
  },
  input: {
    marginBottom: 40,
    color: "#fff",
    marginHorizontal: 30,
    alignSelf: "stretch"
  }
});
