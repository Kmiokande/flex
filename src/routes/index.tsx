import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';

import Calculate from '../pages/Calculate';

const Auth = createStackNavigator();

const AuthRoutes: React.FC = () => {
  return (
    <Auth.Navigator
      screenOptions={{
        headerShown: false,
        cardStyle: { backgroundColor: '#312e38' },
      }}
    >
      <Auth.Screen name="Calculate" component={Calculate} />
    </Auth.Navigator>
  );
};

export default AuthRoutes;
