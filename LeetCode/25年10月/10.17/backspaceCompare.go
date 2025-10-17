package temp

func backspaceCompare(s string, t string) bool {
	m := len(s)
	n := len(t)

	Ns := make([]byte, 0, m)
	Nt := make([]byte, 0, n)

	for _, v := range s {
		switch v {
		case '#':
			if len(Ns) > 0 {
				Ns = Ns[:len(Ns)-1]
			}
		default:
			Ns = append(Ns, byte(v))
		}
	}

	for _, v := range t {
		switch v {
		case '#':
			if len(Nt) > 0 {
				Nt = Nt[:len(Nt)-1]
			}
		default:
			Nt = append(Nt, byte(v))
		}
	}

	if len(Nt) != len(Ns) {
		return false
	}
	for i := range Ns {
		if Ns[i] != Nt[i] {
			return false
		}
	}
	return true
}
