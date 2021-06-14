import React from 'react';
import { ScrollView } from 'react-native';

import Input from '../../components/Input';

import { Container } from './styles';

const Calculate: React.FC = () => {
  return (
    <ScrollView
      keyboardShouldPersistTaps="handled"
      contentContainerStyle={{ flex: 1 }}
    >
      <Container>
        <Input
          name="gasCash"
          icon="cash-multiple"
          placeholder="Valor do litro de gasolina"
          keyboardType="decimal-pad"
        />
        <Input
          name="gasMileage"
          icon="fuel"
          placeholder="Quilometragem com gasolina"
          keyboardType="decimal-pad"
        />
      </Container>
    </ScrollView>
  );
};

export default Calculate;
