import React from 'react';
import { ScrollView } from 'react-native';

import { Container } from './styles';

const Calculate: React.FC = () => {
  return (
    <ScrollView
      keyboardShouldPersistTaps="handled"
      contentContainerStyle={{ flex: 1 }}
    >
      <Container />
    </ScrollView>
  );
};

export default Calculate;
