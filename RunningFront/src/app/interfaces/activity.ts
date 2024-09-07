import { Effort } from './effort';
import { Type } from './type';

export interface Activity {

    id: number;
    title: string;
    description: string;
    distance: number;
    time: string;
    pace: string;
    calories: number;
    pulse: number;
    date: Date;
  
    // RELACIONES
    type: Type;
    effort: Effort;

}
