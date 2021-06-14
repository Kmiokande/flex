import React from 'react';
import { TextInputProps } from 'react-native';

import { Container, TextInput, Icon } from './styles';

interface InputPros extends TextInputProps {
  name: string;
  icon: string;
}

const Input: React.FC<InputPros> = ({ name, icon, ...rest }) => {
  return (
    <Container>
      <Icon name={icon} size={20} color="#fff" />
      <TextInput
        keyboardAppearance="dark"
        placeholderTextColor="#fff"
        {...rest}
      />
    </Container>
  );
};

export default Input;
