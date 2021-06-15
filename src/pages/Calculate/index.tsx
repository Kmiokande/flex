import React, { useState } from 'react';
import { View, ScrollView } from 'react-native';
import { TextInput } from 'react-native-paper';

const styles = {
  input: {
    marginLeft: 16,
    marginRight: 16,
    marginBottom: 8,
  },
};

const Calculate: React.FC = () => {
  const [text, setText] = useState('');

  return (
    <ScrollView
      keyboardShouldPersistTaps="handled"
      contentContainerStyle={{ flex: 1 }}
    >
      <View style={{ flex: 1, justifyContent: 'center' }}>
        <TextInput
          left={<TextInput.Icon name="fuel" />}
          style={styles.input}
          mode="outlined"
          label="Consumo por quilometragem"
          value={text}
          onChangeText={(text) => setText(text)}
        />
        <TextInput
          left={<TextInput.Icon name="cash-multiple" />}
          style={styles.input}
          mode="outlined"
          label="Valor do litro de gasolina"
          value={text}
          onChangeText={(text) => setText(text)}
        />

        <TextInput
          left={<TextInput.Icon name="fuel" />}
          style={styles.input}
          mode="outlined"
          label="Consumo por quilometragem"
          value={text}
          onChangeText={(text) => setText(text)}
        />
        <TextInput
          left={<TextInput.Icon name="cash-multiple" />}
          style={styles.input}
          mode="outlined"
          label="Valor do litro de etanol"
          value={text}
          onChangeText={(text) => setText(text)}
        />
      </View>
    </ScrollView>
  );
};

export default Calculate;
