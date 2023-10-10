type Concat<T extends unknown[], U extends unknown[]> = [...T, ...U];

type A = "foo";
type B = A extends infer C ? (C extends "foo" ? true : false) : never;

const b: B;
