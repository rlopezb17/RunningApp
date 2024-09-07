import { Activity } from './activity';
import { Country } from './country';
import { Shoes } from './shoes';

export interface User {

    id: number;
    firstName: string;
    lastName: string;
    username: string;
    email: string;
    password: string;
    birthDate: Date; 
    weight: number;
    height: number;
    token: string;

      // RELACIONES
  country: Country;
  activities: Activity[];
  shoes: Shoes[];

}
