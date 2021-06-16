import React from 'react';
import { ScrollView } from 'react-native';

const Calculate: React.FC = () => {
  return (
    <ScrollView
      keyboardShouldPersistTaps="handled"
      contentContainerStyle={{ flex: 1 }}
    />
  );
};

export default Calculate;
