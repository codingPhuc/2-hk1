import itertools
E = {'1', '2', '3', '4', '5'}
k = 3
n = len(E)
permatur_list = list(itertools.combinations(E, k))
print("%i - permutations of %s: " % (k, E))
for i in permatur_list:
    print(i)
print("Number of combinations = %i!/(%i!(%i-%i)!) = %i" %
      (n, k, n, k, len(permatur_list)))
