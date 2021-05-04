import data from './data.json';
export interface SolutionInterface {
  ID: number;
  Name: string;
  Content: string;
}

export const solutions: SolutionInterface[] = data;