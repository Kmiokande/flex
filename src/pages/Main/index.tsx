import React from 'react';
import { Image, StyleSheet, View } from 'react-native';
import { Button, Text } from 'react-native-paper';

import logoImg from '../../assets/logo.png';

const Main: React.FC = () => {
  return (
    <View style={styles.root}>
      <View style={styles.image}>
        <Image source={logoImg} />
      </View>

      <Text style={styles.text}>
        Flex irá te ajudar a escolher o melhor combustível para seu veículo.
      </Text>

      <Button
        style={styles.button}
        mode="contained"
        onPress={() => console.log('Entrar')}
      >
        Entrar
      </Button>

      <Button
        style={styles.button}
        mode="outlined"
        onPress={() => console.log('Criar conta')}
      >
        Criar conta
      </Button>
    </View>
  );
};

const styles = StyleSheet.create({
  root: {
    flex: 1,
    justifyContent: 'center',
    paddingLeft: 16,
    paddingRight: 16,
  },
  image: {
    alignItems: 'center',
    marginBottom: 32,
  },
  text: {
    fontSize: 16,
  },
  button: {
    marginBottom: 8,
  },
});

export default Main;
