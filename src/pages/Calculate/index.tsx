import React from 'react';
import { View, ScrollView } from 'react-native';

import Input from '../../components/Input';
import Button from '../../components/Button';

import { Container, Title } from './styles';

const Calculate: React.FC = () => {
  return (
    <ScrollView
      keyboardShouldPersistTaps="handled"
      contentContainerStyle={{ flex: 1 }}
    >
      <Container>
        <View>
          <Title>Gasolina</Title>
        </View>

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

        <View>
          <Title>Etanol</Title>
        </View>

        <Input
          name="ethCash"
          icon="cash-multiple"
          placeholder="Valor do litro de etanol"
          keyboardType="decimal-pad"
        />
        <Input
          name="ethMileage"
          icon="fuel"
          placeholder="Quilometragem com etanol"
          keyboardType="decimal-pad"
        />

        <Button onPress={() => {}}>Calcular</Button>
      </Container>
    </ScrollView>
  );
};

export default Calculate;
