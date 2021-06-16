import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';

import Main from '../pages/Main';
import Calculate from '../pages/Calculate';

const Auth = createStackNavigator();

const AuthRoutes: React.FC = () => {
  return (
    <Auth.Navigator
      screenOptions={{
        headerShown: false,
        cardStyle: { backgroundColor: '#fff' },
      }}
    >
      <Auth.Screen name="Main" component={Main} />
      <Auth.Screen name="Calculate" component={Calculate} />
    </Auth.Navigator>
  );
};

export default AuthRoutes;
